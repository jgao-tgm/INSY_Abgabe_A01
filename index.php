<form action="index.php" method="post">
  <p>Flugnummer: <input type="text" name="flightnumber" /></p>
  <p><input type="submit"/></p>
</form>

<?php
  echo "</br>";
  echo "</br>";
  include 'connect.php';
  echo "</br>";

  if($_POST['flightnumber']!= NULL)
  {
    try
    {
      $stmt = $conn->prepare("SELECT * FROM flights where flightnr=".$_POST['flightnumber']);
      $stmt->execute();
      $result = $stmt->setFetchMode(PDO::FETCH_ASSOC);
    }
    catch(PDOException $e)
    {
      echo "Error: " . $e->getMessage();
      echo "</br>";
    }

    if ($stmt->execute())
    {
      
      while ($row = $stmt->fetch(PDO::FETCH_ASSOC))
      {
		  echo "</br>Airline: ".$row['airline']."</br>Flugnummer: ".$row['flightnr']."</br>Abflug-Zeit: ".$row['departure_time']."<br>Abflug-Ort: ".$row['departure_airport']."</br>Ankunft-Zeit: ".$row['destination_time']."</br>Ankunft-Ort: ".$row['destination_airport']."</br>Flugzeugtype: ".$row['planetype'];
        }
    echo "</br>";
    echo "</br>";
    echo "</br>";
    }
    $stmt = $conn->prepare("SELECT * FROM passengers where flightnr=".$_POST['flightnumber']." order by rownr,seatposition asc");

    if ($stmt->execute())
    {
      echo "<table>";

      echo "<tr><th>id</th><th>Vorname</th><th>Nachname</th><th>Airline</th><th>Flugnummer</th><th>Reihe</th><th>Platz</th><th>Löschen</th></tr>";
      while ($row = $stmt->fetch(PDO::FETCH_ASSOC))
      {
        echo "<tr>
  	          <th>".$row['id']."</th>
  	          <th>".$row['firstname']."</th>
  	          <th>".$row['lastname']."</th>
  	          <th>".$row['airline']."</th>
  	          <th>".$row['flightnr']."</th>
  	          <th>".$row['rownr']."</th>
              <th>".$row['seatposition']."</th>
              <th> <form action='delete.php' method='post'><Button type='submit' name='id' id='".$row['id']."' value='".$row['id']."'>Löschen</button></form></th>
			  </tr>";
      }
      echo "</table>";
    }
  }
?>
