![bilibili-comments-analysis](https://socialify.git.ci/fattydelivery/bilibili-comments-analysis/image?descriptionEditable=bilibili%20comments-analysis&font=Source%20Code%20Pro&forks=1&issues=1&language=1&logo=https%3A%2F%2Favatars2.githubusercontent.com%2Fu%2F51746996%3Fs%3D200%26v%3D4&owner=1&pattern=Circuit%20Board&pulls=1&stargazers=1&theme=Light)

# Bilibili Comments Analysis Website

Team: <a href="https://github.com/fattydelivery">FattyDelivery</a>

- <a href="https://github.com/beiyuouo">Jayce(Bingjie Yan)</a>
- <a href="https://github.com/Lannaie">Bonnie(Nan Wang)</a>
- <a href="https://github.com/hnutc">Krystal(Chang Teng)</a>
- <a href="https://github.com/ibrothercow">Daniel(Cong Niu)</a>

README [ <a href="README.md">EN</a> | <a href="README_CN.md">CN</a> ]

<!-- MarkdownTOC levels="2,3" autolink="true" style="unordered" -->

- [Software Requirements Specification](#software-requirements-specification)
- [Getting Start](#getting-start)
    - [MySQL](#mysql)
    - [HBASE](#hbase)
    - [KAFKA](#kafka)
    - [Properties](#properties)
- [TODO](#todo)
- [Changelog](#changelog)
    - [20210106 v1.0.0](#20210106-v100)
    - [20201218 v0.0.1](#20201218-v001)

<!-- /MarkdownTOC -->


## Software Requirements Specification

SRS [ <a href="SRS.md">EN</a> | <a href="SRS_CN.md">CN</a> ]

## Getting Start
### MySQL

run `resource/sql/sql.sql`


### HBASE

```
hbase shell
disable 'WordsWC'
drop 'WordsWC'

disable 'TimeWC'
drop 'TimeWC'

create 'WordsWC', 'cf'
create 'TimeWC', 'cf'
```

### KAFKA

```
kafka-topics.sh --bootstrap-server hadoop0:9092 --delete --topic project
kafka-topics.sh --bootstrap-server hadoop0:9092 --create --topic project --partitions 2 --replication-factor 1
```

### Properties
Change `resource/cluster.properties` and `resource/database.properties`

## TODO
- [ ] Bvid legal check.
- [ ] Hbase connection release.
- [ ] Nginx

## Changelog

### 20210106 v1.0.0

- Congratulations! All basic functions have been completed and the demo version is online.


### 20201218 v0.0.1

- Add SRS



