<?php
    include 'Connection.php';

    // SQL untuk menampilkan data
    $sql = "SELECT * FROM Material";
    
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
        $material = $result;
    }else{
        $status = false;
        $material = null;
    }

    //convert array ke json (wajib)
    $response_json = json_encode($material);

    echo $response_json;

?>