#!/usr/bin/env python3
import json
import sys

res = {}
data = open(sys.argv[2])
key = sys.argv[1]

for line in data:
    js = json.loads(line)
    if js.get(key):
        val = js.get(key)
        if val not in res:
            res.update({
                js.get(key) : 1
            })
        else:
            res[val] += 1

with open(sys.argv[2] + '.' + sys.argv[1], 'w') as f:
    tmp = dict(sorted(res.items(), key=lambda item: item[1], reverse=True))
    for k, v in tmp.items():
        print(v, k, file=f)
///////////////////////////////////////////////////////////////////////////////////////
        import json
        import sys
        from typing import Any


        def main():
            filename = sys.argv[1]

            result: dict[Any, dict[Any, Any]] = {}

            """
            {
                "key1": {
                    "key1": "value",
                    "key2": "value",
                    "key3": {
                        "key1" : "value"
                    }
                }
            }
            """

            with open(filename, 'r') as data:
                for line in data:
                    json_object: dict[Any, Any] = json.loads(line)
                    for key in json_object.keys():
                        value = json_object[key]
                        if key in result:
                            if value in result[key]:
                                result[key][value] += 1
                            else:
                                result[key].update({value: 1})
                        else:
                            result.update({key: {json_object[key]: 1}})
            output: dict[Any, Any] = {}

            for key in result.keys():
                output.update({key: len(result[key].keys())})

            output = dict(sorted(output.items(), key=lambda x: x[1], reverse=True))

            for item in output.items():
                print(f'{item[0]}: {item[1]}')

            # HashMap<Object, HashMap<Object, Integer>> = new HashMap()

        if __name__ == "__main__":
            main()