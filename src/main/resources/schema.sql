create table measure
(
  id           serial8     not null primary key,
  sensor_id    varchar(50) not null,
  timestamp    timestamp   not null,
  ds_timestamp timestamp   not null,
  data         jsonb
);
