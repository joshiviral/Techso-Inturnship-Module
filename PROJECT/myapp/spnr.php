<?php 

$sql = "SELECT * FROM faculty";

require_once('conn.php');

$r = mysqli_query($connn,$sql);

$result = array();

while($row = mysqli_fetch_array($r)){
    array_push($result,array(
        'fname'=>$row['fname'],
        'email'=>$row['email'],
        'contact'=>$row['contact'],
        'coursespecial'=>$row['coursespecial']
    ));
}

echo json_encode(array('result'=>$result));

mysqli_close($connn);
?>