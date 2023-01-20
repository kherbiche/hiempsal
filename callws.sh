#!/bin/bash
echo "call ws to save User[James, 2000-12-31, fRaNcE, +3699999999, Male]"
curl -X POST http://localhost:8088/api/users -H "Content-Type:application/json" -d '{"name":"James", "birthDate":"2000-12-31","country":"fRaNcE","phone":"+3699999999","gender":"Male"}'
echo
echo "call ws to save User[Kevin, 1999-10-01, fRaNcE, +3600000000, Male]"
curl -X POST http://localhost:8088/api/users -H "Content-Type:application/json" -d '{"name":"Kevin", "birthDate":"1999-10-01","country":"fRaNcE","phone":"+3600000000","gender":"Male"}'
echo
echo "call ws to save User[Sara, 1939-04-15, fRaNcE, +3611111111, Female]"
curl -X POST http://localhost:8088/api/users -H "Content-Type:application/json" -d '{"name":"Sara", "birthDate":"1939-04-15","country":"fRaNcE","phone":"+3611111111","gender":"Female"}'
echo
echo "find User by id=1"
curl http://localhost:8088/api/users/1
echo
echo "find User by id=2"
curl http://localhost:8088/api/users/2
echo
echo "find User by id=3"
curl http://localhost:8088/api/users/3
echo
echo "find User by id=4"
curl http://localhost:8088/api/users/4
echo
echo "find User by id=5"
curl http://localhost:8088/api/users/5
echo
