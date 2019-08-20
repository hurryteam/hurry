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
                    <form role="form" method="post" action="/hurry/manager/question/save">
                        <div class="form-group">
                            <label for="questionId">问题id</label>
                            <input name="questionId" type="text" class="form-control" id="questionId" value="${question.questionId}" readonly="readonly"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">用户id</label>
                            <input name="userId" type="text" class="form-control" id="exampleInputEmail1" value="${question.userId}" readonly="readonly"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">问题详情</label>
                            <input type="text" name="questionContent" class="form-control" id="exampleInputPassword1" value="${question.questionContent}"/>
                        </div>
                        <button type="submit" class="btn btn-default">确认修改</button>
                    </form>
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
