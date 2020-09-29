<?php
    include 'Connection.php';
    
    $material_ID = $_GET['material_ID'];
    $location_ID = $_GET['location_ID'];
    $qty = $_GET['qty'];
    $user_ID = $_GET['user_ID'];
    
    $sql_query = "UPDATE Stock s 
                    SET  s.qty = (s.qty + $qty)
                    WHERE s.materialID = '$material_ID'
                    AND s.storageLocationID = '$location_ID'";
    
    if(mysqli_query($conn,$sql_query)){
        echo 'Data Inserted Successfully';
    }else{
        echo 'Try Again Update Stock';
    }
    

?>