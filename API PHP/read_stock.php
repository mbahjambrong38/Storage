<?php
    include 'Connection.php';

    // SQL untuk menampilkan data
    $sql = "SELECT m.materialDesc, m.materialID, s.qty, s.totalValuation, sl.storageLocationID, sl.storageLocationDesc, p.plantID, p.plantDesc FROM Stock s, Material m, Plant p, Storage_Location sl
        WHERE p.plantID = sl.plantID AND sl.storageLocationID = s.storageLocationID AND s.materialID = m.materialID";
    
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
        $stock = $result;
    }else{
        $status = false;
        $stock = null;
    }

    //convert array ke json (wajib)
    $response_json = json_encode($stock);

    echo $response_json;

?>