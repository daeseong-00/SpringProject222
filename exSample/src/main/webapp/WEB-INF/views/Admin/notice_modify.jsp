<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>공지사항 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
	color: #606060;
}
body {
	margin-left: 0px;
	margin-top: 0px;
}
-->
</style>
<script>
	function notice_send(){
		if(!notice.subject.value){
			alert("제목을 입력하세여");
			notice.subject.focus();
			return;
		}
		
		if(!notice.contents.value){
			alert("내용을 입력하세여");
			notice.contents.focus();
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
					<td height=40 align="center" style="font-size: 15px;"><b>공지사항 [쓰기][수정]</b></a>
					</b></td>
				</tr>
			</table><br>
			<form name="notice" method="post" action="/Admin/Notice/notice_modify">
			<input type="hidden" name="idx" value="${notice.idx}">
			<input type="hidden" name="page" value="${page}">
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>작성자 ID</strong></td>
								<td bgcolor="ffffff"><input name="adid" type="text" value="admin1" readonly style="width:150; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>제목</strong></td>
								<td bgcolor="ffffff"><input name="subject" type="text" value="${notice.subject}"  style="width:400; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>내용</strong></td>
								<td bgcolor="ffffff"><textarea name="contents" cols="10" rows="10" style="width:440; height:200; padding:2; border:1 solid slategray" tabindex="2">${notice.contents}</textarea></td>
							</tr>
						</table>
					</td>
				</tr>

			</table><br>
			</form>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center><a href="javascript:notice_send()"><b>[수정]</b></a>&nbsp; <a href="javascript:history.back()"><b>[취소]</b></a></td>
				</tr>
			</table>
		</td>
	</tr>
</table>			
</body>
</html>
