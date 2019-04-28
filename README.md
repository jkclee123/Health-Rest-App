# Health Rest App


## API

| Http Method | End Point | Description |
| --- | --- | --- |
| `POST` | /person | Insert person with form data |
| `GET` | /person | Get all person |
| `GET` | /person/{personId} | Get person by id |
| `DELETE` | /person/{personId} | Delete person by id |
| `POST` | /measurements | Insert measurements with form data |
| `GET` | /measurements | Get all measurements |
| `GET` | /measurements/{personId} | Get person by person id |
| `PUT` | /measurements/{personId} | Update measurements by person id |
| `GET` | /height/age?rangeSize= | Get average height of person group by age of range size |
| `GET` | /weight/age?rangeSize= | Get average weightof person group by age of range size |
| `GET` | /bmi/{personId} | Get BMI of person by id |

## Form Data

> Sample form data for person


```json
{
  "id":1,
  "name":"Tony Stark",
  "dateOfBirth":"2019-04-28"
}
```
