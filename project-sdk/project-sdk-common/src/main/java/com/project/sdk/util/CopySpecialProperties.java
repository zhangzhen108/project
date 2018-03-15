package com.project.sdk.util;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;

/**.
 * 拷贝类属性的方法
 *
 * @author luoqi
 */

public class CopySpecialProperties {
  /**.
   * 作者：罗琦
   * 拷贝Bean1到Bean2，只拷贝Bean1中不为空的属性
   *
   * @param source 拷贝源Bean
   * @param target 拷贝的目标Bean
   * @return 返回结果
   * @throws Exception 返回结果
   */
  public static Object copyBeanToBean(Object source, Object target)
      throws Exception {
    return copyBeanToBean(source, target, false);
  }

  /**.
   * 作者：罗琦-田加顺-贾伟光
   * 拷贝Bean1到Bean2，只拷贝Bean1中不为空的属性
   *
   * @param source    拷贝源Bean
   * @param target    拷贝的目标Bean
   * @param withBlank 过滤源属性为String并且为空的字段，true时过滤，false不过滤
   * @return 返回结果
   * @throws Exception 返回结果
   */
  public static Object copyBeanToBean(Object source, Object target, boolean withBlank)
      throws Exception {
    Method[] method1 = source.getClass().getMethods();
    Method[] method2 = target.getClass().getMethods();
    String methodName1;
    String methodFix1;
    String methodName2;
    String methodFix2;
    for (int i = 0; i < method1.length; i++) {
      methodName1 = method1[i].getName();
      methodFix1 = methodName1.substring(3, methodName1.length());
      if (methodName1.startsWith("get")) {
        for (int j = 0; j < method2.length; j++) {
          methodName2 = method2[j].getName();
          methodFix2 = methodName2.substring(3, methodName2.length());
          if (methodName2.startsWith("set")) {
            if (methodFix2.equals(methodFix1)) {
              Object[] objs1 = new Object[0];
              Object[] objs2 = new Object[1];
              objs2[0] = method1[i].invoke(source, objs1);
              //如果原对象的属性不为空再拷贝的目标对象
              if (null != objs2[0]) {
                if (withBlank && objs2[0] instanceof String) {
                  if (StringUtils.isNotBlank(objs2[0].toString())) {
                    method2[j].invoke(target, objs2);
                  }
                } else {
                  method2[j].invoke(target, objs2);
                }
              }
              continue;
            }
          }
        }
      }
    }
    return target;
  }
}
