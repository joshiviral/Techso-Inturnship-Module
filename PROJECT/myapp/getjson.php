<?php
$conn = new mysqli("localhost","root","","myapp");
$mysql_qry = "select * from course";
$result = mysqli_query($conn, $mysql_qry);
$json = array();
if(mysqli_num_rows($result)>0)
{
	while($row = mysqli_fetch_assoc($result))
	{
		$r['jsonresult'][] = $row;
	}
	echo json_encode($r);
}
$conn -> close();

?>