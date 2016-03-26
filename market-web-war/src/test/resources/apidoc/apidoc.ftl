


<table class="confluenceTable">
    <tbody>
    <tr>
        <th class="confluenceTh" colspan="6">协议总览</th>
    </tr>
    <tr>
        <td class="highlight-grey confluenceTd" data-highlight-colour="grey"></td>
        <td class="highlight-grey confluenceTd" data-highlight-colour="grey">协议接口</td>
        <td class="highlight-grey confluenceTd" data-highlight-colour="grey">协议url</td>
        <td class="highlight-grey confluenceTd" data-highlight-colour="grey">协议说明</td>
        <td class="highlight-grey confluenceTd" data-highlight-colour="grey">请求方式</td>
        <td class="highlight-grey confluenceTd" data-highlight-colour="grey">请求参数</td>
    </tr>
    <#list apiDoc.apiSummaryList as apiSummary>
    <tr>
        <td class="confluenceTd">${apiSummary_index + 1}</td>
        <td class="confluenceTd">${apiSummary.name}</td>
        <td class="confluenceTd">${apiSummary.url}</td>
        <td class="confluenceTd">${apiSummary.desc}</td>
        <td class="confluenceTd">${apiSummary.requestType}</td>
        <td class="confluenceTd"></td>
    </tr>
    </#list>
    </tbody>
    <tr></tr>
</table>

<p/><p/>
<#list apiDoc.apiDetailList as apiDetail>
<li>
${apiDetail_index + 1}. ${apiDetail.url}  【${apiDetail.name}】<br>
${apiDetail.desc}

    <#if apiDetail.pathVar?exists>
        <#if (apiDetail.pathVar?size >0)>
            <table class="confluenceTable">
                <tbody>
                <tr>
                    <th class="confluenceTh" colspan="7">url路径</th>
                </tr>
                <tr>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey"></td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">名称</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">类型</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">是否必须</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">示例值</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">默认值</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">描述</td>
                </tr>
                    <#list apiDetail.pathVar as pathVar>
                    <tr>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd">${pathVar.name}</td>
                        <td class="confluenceTd">${pathVar.type}</td>
                        <td class="confluenceTd">true</td>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd">${pathVar.desc}</td>
                    </tr>
                    </#list>
                </tbody>
                <tr></tr>
            </table>
        </#if>
    </#if>

    <#if apiDetail.params?exists>
        <#if (apiDetail.params?size >0)>
            <table class="confluenceTable">
                <tbody>
                <tr>
                    <th class="confluenceTh" colspan="7">url参数</th>
                </tr>
                <tr>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey"></td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">名称</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">类型</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">是否必须</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">示例值</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">默认值</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">描述</td>
                </tr>
                    <#list apiDetail.params as param>
                    <tr>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd">${param.name}</td>
                        <td class="confluenceTd">${param.type}</td>
                        <td class="confluenceTd">true</td>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd">${param.desc}</td>
                    </tr>
                    </#list>
                </tbody>
                <tr></tr>
            </table>
        </#if>
    </#if>

    <table class="confluenceTable">
        <tbody>
        <tr>
            <th class="confluenceTh" colspan="7">请求参数(<#if apiDetail.requestType?exists> ${apiDetail.requestType} </#if> <#if apiDetail.requestDesc?exists>【${apiDetail.requestDesc}】</#if>)</th>
        </tr>
            <#if apiDetail.request?exists>
                <#if (apiDetail.request?size >0)>
                <tr>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey"></td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">名称</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">类型</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">是否必须</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">示例值</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">默认值</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">描述</td>
                </tr>

                    <#list apiDetail.request as request>
                    <tr>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd">${request.name}</td>
                        <td class="confluenceTd">${request.type}</td>
                        <td class="confluenceTd">true</td>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd"><#if request.desc?exists>${request.desc}</#if></td>
                    </tr>
                    </#list>
                </#if>
            </#if>
        </tbody>
        <tr></tr>
    </table>

    <table class="confluenceTable">
        <tbody>
        <tr>
            <th class="confluenceTh" colspan="7">返回值(${apiDetail.responseType} 【${apiDetail.returnDesc}】)</th>
        </tr>
            <#if apiDetail.response?exists>
                <#if (apiDetail.response?size >0)>
                <tr>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey"></td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">名称</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">类型</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">是否必须</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">示例值</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">默认值</td>
                    <td class="highlight-grey confluenceTd" data-highlight-colour="grey">描述</td>
                </tr>
                    <#list apiDetail.response as response>
                    <tr>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd">${response.name}</td>
                        <td class="confluenceTd">${response.type}</td>
                        <td class="confluenceTd">true</td>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd"></td>
                        <td class="confluenceTd"><#if response.desc?exists>${response.desc}</#if></td>
                    </tr>
                    </#list>
                </#if>
            </#if>
        </tbody>
        <tr></tr>
    </table>
</li>
<p/><p/>
</#list>