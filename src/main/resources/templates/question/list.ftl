<html>
<#include "../common/header.ftl">
<body>
    <div id="wrapper" class="toggled">
<#--        边栏-->
        <#include "../common/nav.ftl">
<#--        主要内容-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>问题id</th>
                                <th>提问人id</th>
                                <th>问题详情</th>
                                <th colspan="2">问题管理</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list questions.content as q>
                                <tr>
                                    <td>${q.questionId}</td>
                                    <td>${q.userId}</td>
                                    <td>${q.questionContent}</td>
                                    <td>修改</td>
                                    <td><a href="/hurry/manager/question/delete?questionId=${q.questionId}">删除</a></td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#if curPage lte 1>
                                <li class="disabled"><a href="#">上一页</a></li>
                            <#else>
                                <li><a href="/hurry/manager/question/list?page=${curPage-1}&size=${size}">上一页</a></li>
                            </#if>
                            <#list 1..questions.getTotalPages() as index>
                                <#if curPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/hurry/manager/question/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                            <#if curPage gte questions.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/hurry/manager/question/list?page=${curPage+1}&size=${size}">下一页</a></li>
                            </#if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>


<#--<#list questions.content as questions>-->
<#--    ${questions.questionContent}<br>-->
<#--</#list>-->