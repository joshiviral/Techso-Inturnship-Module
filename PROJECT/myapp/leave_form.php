<?php
require "conn.php";
$sname = "afs";//$_POST["name"];
$fname = "edgbr";//$_POST["email"];
$course = "2324";//$_POST["contact"];
$durtn_days = "PHP";//$_POST["coursespecial"];
$reasone = "PHP";//$_POST["coursespecial"];

$mysql_qry1 = "insert into leave (sname,fname,course,durtn_days,reasone) values ('$sname','$fname','$course','$durtn_days','$reasone')";

if($connn->query($mysql_qry1) === TRUE) 
{
echo "Successfully Insert";
}
else
{
echo "Error" ;
}
$connn->close();
?>