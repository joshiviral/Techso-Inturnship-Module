<?php
require "conn.php";
$course_name = $_POST["course"];

$mysql_qry = "insert into course (cname) values ('$course_name')";

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