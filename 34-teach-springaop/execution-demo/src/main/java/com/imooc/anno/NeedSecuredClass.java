package com.imooc.anno;

import java.lang.annotation.*;

/**
 * Created by cat on 2016-12-04.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@Inherited
public @interface NeedSecuredClass {
}
