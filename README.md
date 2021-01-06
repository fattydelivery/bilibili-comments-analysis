# Bilibili Comments Analysis Website

Team: <a href="https://github.com/fattydelivery">FattyDelivery</a>

- <a href="https://github.com/beiyuouo">Jayce(Bingjie Yan)</a>
- <a href="https://github.com/Lannaie">Bonnie(Nan Wang)</a>
- <a href="https://github.com/hnutc">Krystal(Chang Teng)</a>
- <a href="https://github.com/ibrothercow">Daniel(Cong Niu)</a>

README [ <a href="README.md">EN</a> | <a href="README_CN.md">CN</a> ]

<!-- MarkdownTOC levels="2,3" autolink="true" style="unordered" -->

- [Software Requirements Specification](#software-requirements-specification)
- [MySQL](#mysql)
- [HBASE](#hbase)
- [KAFKA](#kafka)
- [TODO](#todo)
- [Changelog](#changelog)
    - [20210106 v1.0.0](#20210106-v100)
    - [20201218 v0.0.1](#20201218-v001)

<!-- /MarkdownTOC -->


## Software Requirements Specification

SRS [ <a href="SRS.md">EN</a> | <a href="SRS_CN.md">CN</a> ]

## MySQL

run `resource/sql/sql.sql`


## HBASE

```
hbase shell
disable 'WordsWC'
drop 'WordsWC'

disable 'TimeWC'
drop 'TimeWC'

create 'WordsWC', 'cf'
create 'TimeWC', 'cf'
```

## KAFKA

```
kafka-topics.sh --bootstrap-server hadoop0:9092 --delete --topic project
kafka-topics.sh --bootstrap-server hadoop0:9092 --create --topic project --partitions 2 --replication-factor 1
```





## TODO

## Changelog

### 20210106 v1.0.0

- Congratulations! All basic functions have been completed and the demo version is online.


### 20201218 v0.0.1

- Add SRS



