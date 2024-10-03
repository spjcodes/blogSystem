package com.jiayeli.blog.common.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
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
                            .outputDir("/tmp/dolen"); // 指定输出目录
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
//                        builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
                        builder.parent("cn.jiayeli.dolen.generator") // 设置父包名
                                .moduleName("testPackage") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "/tmp/dolen/mapper")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("comments") // 设置需要生成的表名
                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                                .addTableSuffix("Model")
                )
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new VelocityTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
