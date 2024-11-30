package com.jiayeli.blog.common.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * @author: jiayeli.cn
 * @description
 * @date: 2023/7/9 下午8:00
 */
public class mybatisPluseGenrator {
    public static void main(String[] args) {
        FastAutoGenerator.create(
                "jdbc:mysql://localhost:3306/blog?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=UTF-8&&serverTimezone=GMT%2B8&useSSL=false",
                "kuro",
                "kuro@Pass")
                .globalConfig(builder -> {
                    builder.author("kuro@jiayeli.cn") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("/tmp/dolen") // 指定输出目录
                            .disableOpenDir() // 允许自动打开输出目录
                            .dateType(DateType.ONLY_DATE) // 设置时间类型策略
                            .commentDate("yyyy-MM-dd HH:mm:ss"); // 设置注释日期格式
//                            .enableKotlin() // 开启 Kotlin 模式
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->

                        builder.parent("src.main.java.com.jiayeli.blog")   // 设置父包名
                                .moduleName("")             // 设置父包模块名
                                .entity("model")            //设置 Entity 包名
                                .mapper("dao")              //设置 Mapper 包名
                                .controller("control")      //设置 Controller 包名
                                .service("service")         //设置 Service 包名
                                .serviceImpl("service.impl")//设置 Service Impl 包名
                                .xml("mapper")              //设置 Mapper XML 包名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "/tmp/dolen/src/main/resources/mapper")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("articleCategory", "articleCategoryInfo") // 设置需要生成的表名 | 增加表匹配(内存过滤)
                                .enableCapitalMode()    //开启大写命名
                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                                .addTableSuffix("Model")
                                .entityBuilder()
                                .enableLombok() // 启用 Lombok
                                .enableTableFieldAnnotation() // 启用字段注解
                                .controllerBuilder()
                                .enableHyphenStyle()
//                                .enableFileOverride()
//                                .enableRestStyle() // 启用 REST 风格
                        /*        .controllerBuilder()
                                .mapperBuilder()
                                .serviceBuilder()*/

                )
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
