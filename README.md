# README #

software list:

mysql 5.7
java 8.0


STEPS to execute :

1.Run scripts/db.sql  to create tables payment_term and invoice

2.navigate to app_core folder and "mvn install" to package and install in local .m2 repository

3.navigate to payment_term folder and "mvn package" to generate jar in target

4.navigate to target folder and start payment-term-service using "java -jar payment-term-0.0.1-SNAPSHOT.jar"

5.navigate to invoice folder and "mvn package" to generate jar in target

6.navigate to target folder andstart invoice-service using "java -jar invoice-app-0.0.1-SNAPSHOT.jar"


Additional Info:

Scheduler runs every morning 5.00 am to send reminders to valid unpaid invoices

payterm-term-service url's can be accessed at "localhost:8090/api/v1/swagger-ui.html"