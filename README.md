# ProductReview

Used java version 1.8
Tomcat Version 8.0

The project implements resful API to identify if a product review comment has objectionable content.

The API Access Path is :
http://<Hostname>:<Port No>/productReview/webapi/comment/checkObjectionable 

It accepts a JSON format intput of Comment Object, Sample :
{
	"commentStr":"Fuck Off!"
}

and returns a JSON output identifying if the comment is objectionable and what type of content it has, Sample :

{
    "contentType": "Obscene",
    "isObjectionable": true
}

Below is the API Interface:
com.chandni.productReview.api.ICommentClassifier
