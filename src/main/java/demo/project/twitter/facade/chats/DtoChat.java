package demo.project.twitter.facade.chats;

import org.springframework.stereotype.Service;

@Service
public class DtoChat {
/* в зтом классе создаются только те поля, которые необходимы для работы с данной сущностью фронту. Именно эти поля
 будут передаваться в JSON в request и response
 Внимание!!!!!
 Название и тип поля должен полностью совпадать с названием и типом поля в классе соответсвующей entity.
 В этом классе могут быть не все поля соответсвующей entity, а только те, которые необходимы фронту. Порядок
 декларирования полей значения не имеет.
  */

/*******************Данные поля созданы для примера**************************/
    private Long id;
    private Long version;


}
