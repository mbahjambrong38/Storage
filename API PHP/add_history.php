<?php
    include 'Connection.php';
    
    $sql_query1 = "SELECT COUNT(*) AS 'Count' FROM History";
    
    $query = $conn->query($sql_query1);

    
    $result = array();
    
    while($data = $query->fetch_assoc()){

        $count = $data['Count'];

    }
    
    if($count == 0){
        $ID = "HS" . "00000001";
    }else if($count < 9){
        $ID = "HS" . "0000000" . ($count+1);
    }else if($count < 99){
        $ID = "HS" . "000000" . ($count+1);
    }else if($count < 999){
        $ID = "HS" . "00000" . ($count+1);
    }else if($count < 9999){
        $ID = "HS" . "0000" . ($count+1);
    }else if($count < 99999){
        $ID = "HS" . "000" . ($count+1);
    }else if($count < 999999){
        $ID = "HS" . "00" . ($count+1);
    }else if($count < 9999999){
        $ID = "HS" . "0" . ($count+1);
    }else if($count < 99999999){
        $ID = "HS" . ($count+1);
    }
    
    $material_ID = $_GET['material_ID'];
    $location_ID = $_GET['location_ID'];
    $qty = $_GET['qty'];
    $user_ID = $_GET['user_ID'];
    
    $sql_query = "INSERT INTO History(historyID,qty,userID,materialID,storageLocationID) VALUES('$ID',$qty,'$user_ID','$material_ID','$location_ID')";
                  
    
    if(mysqli_query($conn,$sql_query)){
        echo "Data Inserted Successfully '$ID'";
    }else{
        echo "Try Again History '$ID' '$material_ID' '$locationID' $qty";
    }
    
    mysqli_close($conn);

?>