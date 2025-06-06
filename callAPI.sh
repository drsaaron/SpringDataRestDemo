#! /bin/sh 

url=http://localhost:8080/person

echo "creating user"
curl -X POST -H 'Content-Type: application/json' -d '{"firstName": "Henrietta", "lastName": "Schmoopie", "age": 45}' $url > /tmp/newPerson.out
newPersonUrl=$(grep href /tmp/newPerson.out | head -1 | awk '{ print $3 }')
echo "new person URL: $newPersonUrl"

echo
echo "getting all users"
curl -i $url

echo
echo "searching"
curl -i $url/search/findByLastName?lastName=Aaron

# add a role
curl -X POST -H 'Content-Type: application/json' -d '{"startDate": "2023-01-01", "endDate": "2023-12-31", "roleType": "CEO", "personId": '$newPersonUrl'}' http://localhost:8080/role

# add an address
curl -X POST -H 'Content-Type: application/json' -d '{"streetText": "my street", "stateText": "home", "zipCode": "1234", "personId": '$newPersonUrl'}' http://localhost:8080/address

# get the new user, whuich should have a role and address
curl -i $(echo $newPersonUrl|sed -e 's/"//g')
