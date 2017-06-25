package edu.suda.ada.rest;

import edu.suda.ada.api.BlockAPI;
import edu.suda.ada.core.SimpleBlock;
import org.ethereum.jsonrpc.JsonRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by LiYang on 2016/11/26.
 */
@Controller
@RequestMapping("blocks")
public class BlockController {
    @Autowired
    private BlockAPI blockAPI;

    @RequestMapping(value = "byhash", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public SimpleBlock getBlockByHash(@RequestParam("hash") String hash){
        try {
            return blockAPI.getBlockByHash(hash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "byrange", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public List<SimpleBlock> getBlockByHash(@RequestParam("start") int start, @RequestParam("end") int end){
        try {
            return blockAPI.getBlocksByRange(start, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "number", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public long getBlockNumber() {
        try {
            return blockAPI.getBlockNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
