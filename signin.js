$("#confirm").click(function(){
    $.ajax({
        async:false,
        url:"singin",
        data:$("#username").serialize(),
        type:"get",
        datatype:"text",
        success:function(data){
            if(data=='success'){
                alert("signin success");
                window.location.href="contact_main.html?" + $("#username").val() + "";
            }
        }
    })
})