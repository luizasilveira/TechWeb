<!DOCTYPE html>
<html>
  <head>
    <!-- created by OSTON CODE CYPHER -->
    <!--Support/subscribe my channel @ youtube.com/ostoncodecypher -->
      <title>Register</title>
      <meta name="viewport" content="width=device-width,initial-scale=1.0">
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
     <style>
       body{
         background-color:teal;
       }
     
       .progress{
         width:50%;
         margin:0 auto;
         margin-top:20%;
       }
       
       @media only screen and (max-width:924px){
            .progress{
               width:70%;
               margin:0 auto;
               margin-top:60%;
             }
       }
    
     </style>
  </head>
  
  <body>
    
     <div id="flayer">
          <div id="slayer">
    
    <div class="container" id="content">
        
       
        <div class="row">
          <div class="col l3 m3 s12"></div>
          <div class="col l6 m6 s12">
            <form action="" method="POST">
                 <div class="card-panel z-depth-5">
                  <h5 class="center">Register</h5>
                  <p class="center">Join to our community now !</p>
                   <div class="input-field">
                    <i class="material-icons prefix">account_circle</i>
                    <input type="text" name="username">
                    <label>Enter username</label>
                  </div>
                  
                   <div class="input-field">
                    <i class="material-icons prefix">email</i>
                    <input type="email" name="email" class="validate">
                    <label>Enter email</label>
                  </div>
                  
                   <div class="input-field">
                    <i class="material-icons prefix">lock</i>
                    <input type="password" name="pass1">
                    <label>Enter password</label>
                  </div>
                  
                    
                   <div class="input-field">
                    <i class="material-icons prefix">vpn_key</i>
                    <input type="password" name="pass2">
                    <label>Confirm password</label>
                  </div>
                  <p class="right">Already have an account? <a href="#login" class="modal-trigger">login</a></p>
                  <input type="submit" name="submit" value="register" class="btn left col s12">
                
                  <div class="clearfix"></div>
               </div>
            </form>
            
          </div>
            <div class="col l3 m3 s12"></div>
      
          
          
        </div>
    </div>
     </div>
          </div>
      <!-- login form put in the form -->
      <div class="modal modal-fixed-footer" id="login">
        <form action="" method="POST">
            <div class="modal-conent">
              <div class="container">
                    <h5 class="center">Login</h5>
                  <p class="center">Let's talk & share</p>
                  <div class="row">
                  
                    <div class="col m12 s12">
                      <div class="input-field">
                    <i class="material-icons prefix">person</i>
                    <input type="text" name="username">
                    <label>Enter username/email</label>
                  </div>
                  
                  <div class="input-field">
                    <i class="material-icons prefix">lock</i>
                    <input type="password" name="pass1">
                    <label>Enter password</label>
                  </div>
                  <p>
                    <label>
                      <input type="checkbox">
                      <span>Remember me</span>
                    </label>
                  </p>
                    </div>
                    
                  </div>
              </div><!-- end of modal container -->
            </div>
            
            <div class="modal-footer">
                  <div class="container">
                
                      
                         <p class="left">Are you New? <a href="register.php" class="modal-trigger">Register</a></p>
                         <input type="submit" name="submit" value="login" class="btn pulse">
                          <input type="button"  value="close" class="btn modal-close red">
                      </div>
     
               
                 
                  </div>
            </div>
         </form>
      </div>
    
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <script>
    
      const login = document.querySelectorAll(".modal");
      M.Modal.init(login,{
        opacity:0.7,
        dismissible:false
      });
      
      document.querySelector("#content").style.display="none";
      document.querySelector("#flayer").classList.add("progress");
      document.querySelector("#slayer").classList.add("indeterminate");
      
      setTimeout(function(){
          document.querySelector("#flayer").classList.remove("progress");
          document.querySelector("#slayer").classList.remove("indeterminate");
          document.querySelector("#content").style.display="block";
      },3000)
    </script>
  </body>
</html>