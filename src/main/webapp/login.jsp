<!doctype html>
<html>
<head>
    <title>${param.title==null?"login":title}</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
    <script src="https://use.fontawesome.com/8916abdc27.js"></script>
</head>
<body>
<div class="section"></div>
<main>
    <div class="center-align">
        <div class="section"></div>

        <h5 class="indigo-text">Please, login into your account</h5>
        <div class="section"></div>

        <div class="container">
            <div class="z-depth-1 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

                <form class="col s12" method="post">
                    <div class="row">
                        <div class="col s12">
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input class="validate" type="text" name="login" id="login" />
                            <label for="login">Enter your login</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="input-field col s12">
                            <input class="validate" type="password" name="password" id="password" />
                            <label for="password">Enter your password</label>
                        </div>
                        <label style="float: right;">
                            <a class="pink-text" href="#!"><b>Forgot Password?</b></a>
                        </label>
                    </div>

                    <br />
                    <center>
                        <div class="row">
                            <button type="submit" name="btn_login" class="col s12 btn btn-large waves-effect indigo">Login</button>
                        </div>
                    </center>
                    <center>
                        <div class="row">
                            <button type="submit" name="btn_reg" class="col s12 btn btn-large waves-effect indigo">Registration</button>
                        </div>
                    </center>
                </form>
            </div>
        </div>
    </div>

    <div class="section"></div>
    <div class="section"></div>
</main>
</body>
</html>