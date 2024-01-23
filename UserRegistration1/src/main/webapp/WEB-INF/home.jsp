<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha384-GLhlTQ8i1UqFJYYNl68P6s7FfOVrialF2N3tDCKG5tr5Szkbe5P/SFIIJdA2LZ+e" crossorigin="anonymous">
    <title>Status Buttons</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            background-color: #f0f0f0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .navbar-container {
            width: 100%;
            z-index: 1000;
        }

        .button-container {
            display: flex;
            justify-content: center;
            align-items: center;
            flex-grow: 1; /* Take up remaining vertical space */
        }

        .status-button {
            width: 450px;
            height: 450px;
            font-size: 60px;
            cursor: pointer;
            transition: background-color 0.2s;
            margin: 0 10px; /* Adjusted the spacing between buttons */
            border-radius: 50%;
            border: none;
            outline: none;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            color: white;
            font-weight: bold;
        }

        .status-button:hover {
            transform: scale(1.1);
        }

        .green-bg {
            background-color: #4CAF50; /* Green */
        }

        .blue-bg {
            background-color: #3498db; /* Blue */
        }

        .violet-bg {
            background-color: #8e44ad; /* Violet */
        }

        .notification-icon {
            font-size: 24px;
            color: #495057;
            cursor: pointer;
            margin-left: 15px;
        }
    </style>
</head>
<body>

    <div class="navbar-container">
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Profile
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Profile 1</a></li>
                                <li><a class="dropdown-item" href="#">Profile 2</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Logout</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Notification
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Notification 1</a></li>
                                <li><a class="dropdown-item" href="#">Notification 2</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Logout</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <i class="fas fa-bell notification-icon"></i>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <script>
    function redirectToReview() {
        // Redirect to the toreview.jsp file
        window.location.href = 'toreview.jsp';
    }
    </script>


    <div class="button-container">
        <button class="status-button green-bg" onclick="redirectToReview()">To Review</button>
        <button class="status-button blue-bg" onclick="showReviewed()">Reviewed</button>
        <button class="status-button violet-bg" onclick="showHistory()">History</button>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
