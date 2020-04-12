select count(*) as counts
from seat;

/*小美是一所中学的信息科技老师，她有一张 seat 座位表，平时用来储存学生名字和与他们相对应的座位 id。

其中纵列的 id 是连续递增的

小美想改变相邻俩学生的座位。*/

select (
    case
        when MOD(id,2) != 0 and counts != id then id + 1
        when mod(id,2) != 0 and counts =id then id
        else id - 1

    end) as id
    student
from
    seat,
    (select
        count(*) as counts
     from
        seat) as seat_counts

    order by id asc;