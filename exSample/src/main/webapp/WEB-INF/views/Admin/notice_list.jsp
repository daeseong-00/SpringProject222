<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>공지사항 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css"> 
<!-- 
body,td,tr,table{font-size:9pt; font-family:tahoma;color:#666666;line-height:160%;} 

A:link {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:visited {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:active {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:hover {font-family:tahoma;font-size:9pt;color:#009900;text-decoration:underline;} 
--> 
</style> 
<script>
	function notice_search(){
		if(!notice.key.value){
			alert("검색어를 입력하세요");
			notice.key.focus();
			return;
		}
		notice.submit();
	}
</script>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="top_menu.jsp" flush="true" /></td></tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>공지사항 리스트</b></a>
					</b></td>
				</tr>
			</table><br>
			<table width="80%" border="0" cellspacing="0" cellpadding="0">
				<tr>
                    <td height="20">* 총 등록수 : <font color=red>${totcount}</font> 건</td>
                </tr>
                <tr>
                    <td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
                      <tr bgcolor="EcECEC">
                        <td width="15%" align="center" bgcolor="EcECEC"><strong>번호</strong></td>
						<td align="center" bgcolor="EcECEC"><strong>제목</strong></td>
                        <td width="20%" align="center"><strong>접수일</strong></td>
                        <td width="10%" align="center"><strong>조회수</strong></td>
                      </tr>
			<c:if test="${empty nList}">
                      <tr>
                        <td align="center" bgcolor="#FFFFFF" colspan="4">등록된 공지사항이 없습니다</td>
                      </tr>
			</c:if>
              <c:forEach var="nDTO" items="${nList}">        
                      <tr>
                        <td align="center" bgcolor="#FFFFFF">${listcount}</td>
                        <td bgcolor="#FFFFFF"><a href="/Admin/Notice/notice_view?idx=${nDTO.idx}&page=${page}" class="unnamed1">${nDTO.subject}</a></td>
                        <td align="center" bgcolor="#FFFFFF">${nDTO.regdate}</td>
						<td align="center" bgcolor="#FFFFFF">${nDTO.readcnt}</td>
                      </tr>
                      <c:set var="listcount" value="${listcount-1}" />
              </c:forEach>        
	                  
	                  <tr>
                        <td height="35" colspan="10" align="center" bgcolor="#FFFFFF">${pageSkip}</td>                      </tr>
					<form action="/Admin/Notice/notice_list" method="post" name="notice">
					<input type="hidden" name="page" value="${page}">
                      <tr>
                        <td colspan="10" align="center" bgcolor="#FFFFFF">
                        <table width="610" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width=80% height="30" colspan="2" align="right">
								<select name="search" class="textfield">
									<option value="subject" ${pageSearchDTO.search=='subject' ? 'selected' :'' }>제목</option>
									<option value="contents "${pageSearchDTO.search=='contents' ? 'selected' :'' }>내용</option>
								</select>
								<input name="key" type="text" class="textfield" size="30" value="${pageSearchDTO.key}"></td>
                              <td width=20% align="right"><a href="javascript:notice_search()"><b>[검색]</b></a>  &nbsp;
                              
                              <a href="/Admin/Notice/notice_write?page=${page}"><b>[글쓰기]</b></a></td>
                            </tr>				
                        </table>
                        </td>
                      </tr>
                     </form> 
                    </table>
                   </td>
               </tr>
              
           </table>
       </td>
    </tr>
</table>
                   
</body>
</html>
