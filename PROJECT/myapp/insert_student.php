<?php
require "conn.php";
$fullname = $_POST["nm"];
$address = $_POST["ad"];
$contact = $_POST["cont"];
$email = $_POST["el"];
$facultyname = $_POST["fc"];
$coursename = $_POST["crs"];
$fromdate = $_POST["fd"];
$todate = $_POST["td"];

$mysql_qry = "insert into myappdata (fname,address,contact,email,faculty,course,fromdate,todate) values ('$fullname','$address','$contact','$email','$facultyname','$coursename','$fromdate','$todate')";

if($connn->query($mysql_qry) === TRUE) 
{
echo "Successfully Insert";
}
else
{
echo "Error" ;
}
$connn->close();
?>