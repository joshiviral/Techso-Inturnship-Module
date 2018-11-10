<?php
require "conn.php";
$sname = $_POST["sname"];
$fname = $_POST["fname"];
$course = $_POST["course"];
$duration = $_POST["duration"];
$reason = $_POST["reason"];

$mysql_qry = "insert into myleave (sname,fname,course,duration,reason) values ('$sname','$fname','$course','$duration','$reason')";

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