#pytest
## 命令行参数
>-v 说明：可以输出用例更加详细的执行信息
>
>-m 选择mark条件,执行mark案例
>
>-s 查看调试消息--capture=no\fd\sys
>
> -k 执行用例包含“关键字”的用例
>
> -q 简化控制台的输出
>
> --collect-only 罗列出所有当前目录下所有的测试模块，测试类及测试函数
>
> --tb=style 屏蔽测试用例执行输出的回溯信息，可以简化用例失败时的输出信息
>
> --lf --last-first 当一次用例执行完成后，重新运行失败用例
>
>--ff --failed-first当一次用例执行完成后，先运行失败用例，后运行其他用例
>
> --nf, --new-first 先执行新加的或修改的用例，再执行其它的
>
> --cache-clear：先清除所有缓存，再执行用例
>
>--setup-show 详细信息
>
> --disable-warnings命令行选项来禁止告警信息的展示
##注解的使用
>@pytest.fixture:
>
> fixture(scope="function", params=None, autouse=False, ids=None, name=None)
>>"function" (default)：作用于每个测试方法，每个test都运行一次
>>
>>"class"：作用于整个类，每个class的所有test只运行一次
>>
>>"module"：作用于整个模块，每个module的所有test只运行一次
>>
>>"session"：作用于整个session(慎用)，每个session只运行一次
> >
>>"params"：(list类型)提供参数数据，供调用标记方法的函数使用,依赖request
> >
>>"autouse"：是否自动运行,默认为False不运行，设置为True自动运行
> >
>>"name":指定fixture名称
>
>conftest.py:集中管理fixture，pytest自动调用
>
>yield是在fixture的方法中区分预处理和后处理的关键字

>@pytest.mark:
>
>skip:指定跳过
>
>skipif:指定跳过条件
>
>xfail:预见错误信息
>
>parametrize:参数化
>
>usefixtures:testcase使用fixture
>
>filterwarnings 告警过滤
##内部模块
>tmpdir.mkdir('').join('') 创建临时目录和文件，只在function中
>
> tmpdir_factory.mktemp('a').join('a') 创建临时目录和文件，作用在function, class, module, session中


#jemeter
>./jmeter -n -t [jmx文件路径] -r -l [jtl文件输出路径及文件名] -e -o [html测试报告路径]
>
>-h 帮助
>
>-n 非GUI模式
>
>-t 指定要运行的 JMeter 测试脚本文件
>
>-l 记录结果的文件 每次运行之前，(要确保之前没有运行过,即xxx.jtl不存在，不然报错)
>
>-r Jmter.properties文件中指定的所有远程服务器
>
>-e 在脚本运行结束后生成html报告
>
>-o 用于存放html报告的目录（目录要为空，不然报错）

#nginx负载均衡配置nginx.conf
>配置服务器： upstream ***{ server *** weight=1(down|backup)}
>
>1）down 表示单前的server暂时不参与负载
>
>2）Weight 默认为1.weight越大，负载的权重就越大。
>
> 3）max_fails 允许请求失败的次数默认为1.当超过最大次数时，返回proxy_next_upstream 模块定义的错误
>
>4）fail_timeout max_fails 次失败后，暂停的时间。
>
>5）Backup 其它所有的非backup机器down或者忙的时候，请求backup机器。所以这台机器压力会最轻。

>配置规则：location ~ \.(***|***)$ { }
