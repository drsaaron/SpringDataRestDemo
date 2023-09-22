#! /bin/sh

url=http://localhost:8080/person

echo "creating user"
curl -i -X POST -H 'Content-Type: application/json' -d '{"firstName": "Scott", "lastName": "Aaron", "age": 25}' $url

echo
echo "getting all users"
curl -i $url

echo
echo "searching"
curl -i $url/search/findByLastName?lastName=Aaron
