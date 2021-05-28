这个文件是freemarker的笔记，主要记录一些常用的语法
<#--1、注释 &lt;#&ndash;-->
模版名称：${templateName}

<#-- 使用if else -->
<#if ifFlag == 1>
    ifFlag == 1
<#elseif ifFlag == 2>
    ifFlag == 2
<#else>
    ifFlag == 3
</#if>


<#-- 使用 list -->
<#list names as name>
    <#--  使用freemarker内置函数  -->
    ${name_index + 1}.${name?cap_first} <#if name_has_next>,</#if>
    <#if name == "lisi"><#break ></#if>
</#list>

<#-- 引入其他模块 -->
<#include "includeModel.ftl" encoding="utf-8" parse=false />
