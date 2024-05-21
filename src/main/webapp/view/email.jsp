<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email Form with Attachment</title>
</head>
<body>
    <h1>Contact Us</h1>
    <form action="/sendEmail" method="post" enctype="multipart/form-data">
        <label for="to">Recipient Email:</label>
        <input type="email" id="to" name="to" required><br><br>
        
        <label for="subject">Subject:</label>
        <input type="text" id="subject" name="subject" required><br><br>
        
        <label for="message">Message:</label><br>
        <textarea id="message" name="message" rows="4" cols="50" required></textarea><br><br>
        
        <label for="attachment">Attachment:</label>
        <input type="file" id="attachment" name="attachment"><br><br>
        <h4>Thanks & Regards</h4>
        
        <input type="submit" value="Send Email">
    </form>
</body>
</html>
