package com.yintai.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yintai.demo.pojo.TradeRecord;
import com.yintai.demo.pojo.User;

@Path("/service")
public class RestWebService {
    private static int index = 1;
    private static Map<Integer, TradeRecord> tradeRecordList = new HashMap<Integer, TradeRecord>();

    public RestWebService() {
        if (tradeRecordList.size() == 0) {

            tradeRecordList.put(index, new TradeRecord(index++,
                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()), true, 1, 60.0, 1, new User("1", "张三")));
            tradeRecordList.put(index, new TradeRecord(index++,
                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()), true, 1, 60.0, 1, new User("1", "张三")));
        }
    }

    @GET
    @Path("tradeId={tradeId}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public TradeRecord getMetadata(@PathParam("tradeId") int tradeId) {
        if (tradeRecordList.containsKey(tradeId))
            return tradeRecordList.get(tradeId);
        else
            return new TradeRecord(0, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), false, 0, 0.0, 0,
                    new User("Nil", "Nil"));
    }

    @GET
    @Path("tradeStatus={tradeStatus}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<TradeRecord> getMetadataByStatus(@PathParam("tradeStatus") boolean tradeStatus) {
        List<TradeRecord> tradeRecords = new ArrayList<TradeRecord>();
        // 遍历map的value值
        Collection<TradeRecord> tradeRecordValues = tradeRecordList.values();
        for (TradeRecord tradeRecord : tradeRecordValues) {
            if (tradeStatus == tradeRecord.isTradeStatus()) {
                tradeRecords.add(tradeRecord);
            }
        }
        // 如果没有查询到，返回一个空记录
        if (tradeRecords.size() < 0) {
            tradeRecords.add(new TradeRecord(0, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), false, 0, 0.0,
                    0, new User("Nil", "Nil")));
        }
        return tradeRecords;
    }

    @GET
    @Path("list")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<TradeRecord> getAllTradeRecords() {
        List<TradeRecord> tradeRecords = new ArrayList<TradeRecord>();
        tradeRecords.addAll(tradeRecordList.values());
        return tradeRecords;
    }

    @POST
    @Path("add")
    @Produces("text/plain")
    public String addTradeRecord(@FormParam("tradeStatus") boolean tradeStatus, @FormParam("tradeType") int tradeType,
            @FormParam("tradeAmount") double tradeAmount, @FormParam("tradeCurrency") int tradeCurrency,
            @FormParam("userId") String userId, @FormParam("userName") String userName) {
        tradeRecordList.put(index,

        new TradeRecord(index++, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), tradeStatus, tradeType,
                tradeAmount, tradeCurrency, new User(userId, userName)));
        return String.valueOf(index - 1);
    }
}