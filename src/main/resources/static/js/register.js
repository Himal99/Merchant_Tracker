
$(document).ready(function (){
    getLocation();
    var lat, lon;
    var x=document.getElementById("demo");
    function getLocation(){
        if (navigator.geolocation){
            navigator.geolocation.getCurrentPosition(showPosition,showError,  {
                enableHighAccuracy: false,
                timeout: 5000,
                maximumAge: 0
            });

        }
        else{
           //error msg
        }
    }

    function showPosition(position){
        lat=position.coords.latitude;
        lon=position.coords.longitude;
        displayLocation(lat,lon);
    }

    function showError(error){
        // switch(error.code){
        //     case error.PERMISSION_DENIED:
        //         x.innerHTML="User denied the request for Geolocation."
        //         break;
        //     case error.POSITION_UNAVAILABLE:
        //         x.innerHTML="Location information is unavailable."
        //         break;
        //     case error.TIMEOUT:
        //         x.innerHTML="The request to get user location timed out."
        //         break;
        //     case error.UNKNOWN_ERROR:
        //         x.innerHTML="An unknown error occurred."
        //         break;
        // }
    }

    function displayLocation(latitude,longitude){
        var geocoder;
        geocoder = new google.maps.Geocoder();
        var latlng = new google.maps.LatLng(latitude, longitude);

        geocoder.geocode(
            {'latLng': latlng},
            function(results, status) {
                if (status == google.maps.GeocoderStatus.OK) {
                    if (results[0]) {
                        console.log(results)
                        console.log(results[0].formatted_address);
                        var add= results[0].formatted_address ;
                        var  value=add.split(",");
                        count=value.length;
                        country=value[count-1];
                        state=value[count-2];
                        city=value[count-3];

                    }
                    else  {

                    }
                }
                else {

                }
            }
        );
    }


    $('.app-form').on('submit',()=>{
        var $this = $('.app-form');
        $('#longitude').val(lon)
        $('#latitude').val(lat)
        console.log($('.app-form').serialize())
            $.post('/register/save', $('.app-form').serialize(), function (data){
                console.log(data)
                $('#success-msg').css('display','block'),

                    setInterval(function (){
                        $('#success-msg').css('display','none')
                    }, 2000)
                // window.location.href = "/";
                $('input').val('');

        }).done(

            ).fail(function (xhr, status, err){
                console.log(xhr.responseText, 'sas')
                $('#success-err').css('display','block'),

                    setInterval(function (){
                        $('#success-err').css('display','none')
                    }, 2000)
            })
        return false;
    })

})
