FROM mysql:8.4

ENV MYSQL_ROOT_PASSWORD=rootpass
ENV MYSQL_DATABASE=paymentsdb
ENV MYSQL_USER=paymentsuser
ENV MYSQL_PASSWORD=paymentspass
# Copia el script de inicialización a la ruta que MySQL usa para cargar datos al iniciar

COPY init.sql /docker-entrypoint-initdb.d/