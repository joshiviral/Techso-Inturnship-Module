<?php
require "conn.php";
$faculty_name = $_POST["name"];
$email = $_POST["email"];
$contact = $_POST["contact"];
$course_special = $_POST["coursespecial"];

$mysql_qry = "insert into faculty (fname,email,contact,coursespecial) values ('$faculty_name','$email','$contact','$course_special')";

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