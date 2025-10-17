<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php

    $respuesta = $_POST['numero'];

    $numeroRandom = random_int(1, 50);

    $intentos = 1;

    while($intentos < 6) {
        if($numeroRandom == $respuesta) {
            echo "Has acertado el número!! Que es $numeroRandom";
            break;
        } else {
            echo "No has acertado el número! Inténtalo de nuevo";
            $intentos++;
        }
    }
    if($intentos == 6){
        if($numeroRandom == $respuesta) {
            echo "Has acertado el número!! Que es $numeroRandom";
            break;
        } else {
            echo "No has acertado el número! No hay más oportunidades";
            break;
        }
    }

    ?>
    <br>
    <a href="index.html">Volver a la página principal</a>
</body>
</html>