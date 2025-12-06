$(document).ready(function(){

    $("h1").hide(); // Oculta el h1


    $("p").hide();

    let ocultar = true;
    $("button").click(function(){
        ocultar = !ocultar;
        if (ocultar) {
            $("p").show()
        } else {
            $("p").hide();
        }
    })

    $('h2').on("mouseenter", function() {
        $(this).hide();
      });

});
