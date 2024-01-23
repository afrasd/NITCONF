<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>'To Review' Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .paper-row {
            display: grid;
            grid-template-columns: 1fr 2fr 1fr 1fr 1fr 1fr;
            background-color: #fff;
            border-radius: 8px;
            margin-bottom: 15px;
            padding: 15px;
            overflow: hidden;
            gap: 10px;
            border: 1px solid #ddd; /* Add border to entire row */
            border-bottom: none; /* Remove bottom border to prevent double lines between rows */
        }

        .pdf-id, .title, .status, .revision, .deadline {
            font-weight: bold;
            padding: 10px;
            border-right: 1px solid #ddd; /* Add right border to separate columns */
        }

        .pdf-id {
            grid-column: 1;
        }

        .title {
            grid-column: 2;
            font-size: 18px;
        }

        .review-actions {
            grid-column: 3 / span 2;
            display: flex;
            align-items: center;
        }

        .review-btn, .display-reviews-btn {
            background-color: #4caf50;
            color: #fff;
            padding: 8px;
            margin-right: 10px;
            cursor: pointer;
            border: none;
            border-radius: 4px;
        }

        .display-reviews-btn {
            background-color: #3498db;
        }

        .status {
            grid-column: 4;
            color: #333;
        }

        .revision {
            grid-column: 5;
        }

        .deadline {
            grid-column: 6;
            color: #888;
        }

        .decline-btn {
            grid-column: 6;
            background-color: #e74c3c;
            color: #fff;
            padding: 8px;
            cursor: pointer;
            border: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<div class="paper-row">
    <div class="pdf-id">PDF ID: 123456</div>
    <div class="title">Sample Paper Title</div>
    <div class="review-actions">
        <button class="review-btn" onclick="openReviewPopup()">Review</button>
        <button class="display-reviews-btn" onclick="displayAllReviews()">Display All Reviews</button>
    </div>
    <div class="status">Status: Pending</div>
    <div class="revision">Revision: First</div>
    <div class="deadline">Deadline: January 31, 2024</div>
    <button class="decline-btn" onclick="declineReview()">Decline</button>
</div>

<!-- Add more paper rows as needed -->

<script>
    function openReviewPopup() {
        // Implement logic to open review pop-up
        alert("Opening review pop-up");
    }

    function displayAllReviews() {
        // Implement logic to display all reviews
        alert("Displaying all reviews");
    }

    function declineReview() {
        // Implement logic to handle declining a review
        alert("Review declined");
    }
</script>

</body>
</html>
