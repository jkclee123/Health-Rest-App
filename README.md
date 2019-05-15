# Health Rest App

A Spring Boot REST API application that\
- records individuals' body measurements
- returns statistics with record data 
  - individuals' BMI
  - average measurements against age range

## API

| Http Method | Mapping                  | Description                                             |
| ----------- | ------------------------ | ------------------------------------------------------- |
| `POST`      | /person                  | Insert person with form data                            |
| `GET`       | /person                  | Get all person                                          |
| `GET`       | /person/{personId}       | Get person by id                                        |
| `DELETE`    | /person/{personId}       | Delete person by id                                     |
| `POST`      | /measurements            | Insert measurements with form data                      |
| `GET`       | /measurements            | Get all measurements                                    |
| `GET`       | /measurements/{personId} | Get person by person id                                 |
| `PUT`       | /measurements/{personId} | Update measurements by person id                        |
| `GET`       | /height/age?rangeSize=   | Get average height of person group by age of range size |
| `GET`       | /weight/age?rangeSize=   | Get average weightof person group by age of range size  |
| `GET`       | /bmi/{personId}          | Get BMI of person by id                                 |

## Request

#### Sample Request form data for person

```json
{
  "name": "Tony Stark",
  "dateOfBirth": "2019-04-28"
}
```

#### Sample Request form data for measurements

```json
{
  "height": 120,
  "weight": 70,
  "personId": 1
}
```

`Height` in cm\
`Weight` in kg\
_Person of `personId` must exist_

## Response

#### Sample Response from

`/height/age?rangeSize=5`

```
[
  {
    "ageRange":"45-49",
    "avgValue":"183.73"
  },
  {
    "ageRange":"100-104",
    "avgValue":"181.61"
  }
]
```

`rangeSize` is not required\
_Default value as 10_

#### Sample Response from

`/bmi/1`

```
{
  "person":{
    "id":1,
    "name":"Tony Stark",
    "dateOfBirth":"1970-05-29"
   },
   "bmi":29.69
}
```
