<?php
    include 'Connection.php';

    // SQL untuk menampilkan data
    $sql = "SELECT * FROM Storage_Location";
    
    // masukkan ke method query
    $query = $conn->query($sql);
    
    //siapkan variable penampung array
    $result = array();

    // fetch hasil eksekusi ke array menggunakan fetch_array / fetch_assoc (recomended fetch_assoc)
    while($data = $query->fetch_assoc()){

        //tampilkan
        //print_r($data);
        $result[] = $data;

    }

    // hitung banyak baris array
    if(count($result) > 0){
        $status = true;
        $sLocation = $result;
    }else{
        $status = false;
        $sLocation = null;
    }

    //convert array ke json (wajib)
    $response_json = json_encode($sLocation);

    echo $response_json;

?>