#!/usr/bin/env bash
docker exec -it my-postgres psql -h localhost -U dykn -d dykn
exit 0