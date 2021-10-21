# escape=`

FROM postgres:11
LABEL author="Pedro Monteiro"

ENV POSTGRES_PASSWORD sasa
ENV POSTGRES_DB sampledb

COPY dbscriptsOrder/ /docker-entrypoint-initdb.d/ 