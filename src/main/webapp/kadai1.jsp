<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>消費税の計算</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
		<h1>消費税の計算</h1>
	</header>
	<main>
		<jsp:useBean id="BEAN" class="bean.Kadai1Bean" scope="request" />
		
		<div class="centerBlock">
			<table>
				<tr>
					<td class="back1">金額</td>
					<td class="back2"><jsp:getProperty name="BEAN" property="money" />円</td>
				</tr>
				<tr>
					<td class="back1">税率</td>
					<td class="back2"><jsp:getProperty name="BEAN" property="rate" />%</td>
				</tr>
				<tr>
					<td class="back1">税金</td>
					<td class="back2"> <jsp:getProperty name="BEAN" property="tax" />円</td>
				</tr>
				<tr>
					<td class="back1">税込金額</td>
					<td class="back2"><jsp:getProperty name="BEAN" property="withTax" />円</td>
				</tr>
				<tr>
					<td></td>
					<td><a href="kadai1form.html"><button type=button>戻る</button></a></td>
			</table>
		</div>
	</main>

</html>